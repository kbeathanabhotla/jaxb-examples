package com.tagcmd.example11;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class PartialXmlEventReader implements XMLEventReader {

	private final XMLEventReader reader;
	private final QName qName;
	private boolean skip = false;

	public PartialXmlEventReader(final XMLEventReader reader, final QName element) {
		this.reader = reader;
		this.qName = element;
	}

	@Override
	public String getElementText() throws XMLStreamException {
		return reader.getElementText();
	}

	@Override
	public Object getProperty(final String name) throws IllegalArgumentException {
		return reader.getProperty(name);
	}

	@Override
	public boolean hasNext() {
		return reader.hasNext();
	}

	@Override
	public XMLEvent nextEvent() throws XMLStreamException {
		while (isEof(reader.peek())) {
			reader.nextEvent();
		}

		return reader.nextEvent();
	}

	@Override
	public XMLEvent nextTag() throws XMLStreamException {
		return reader.nextTag();
	}

	@Override
	public XMLEvent peek() throws XMLStreamException {
		return reader.peek();
	}

	@Override
	public Object next() {
		return reader.next();
	}

	@Override
	public void remove() {
		reader.remove();
	}

	@Override
	public void close() throws XMLStreamException {
		reader.close();
	}

	private boolean isEof(final XMLEvent e) {
		boolean returnValue = skip;
		switch (e.getEventType()) {
		case XMLStreamConstants.START_ELEMENT:
			final StartElement se = (StartElement) e;
			if (se.getName().equals(qName)) {
				skip = true;
				returnValue = true;
			}
			break;
		case XMLStreamConstants.END_ELEMENT:
			final EndElement ee = (EndElement) e;
			if (ee.getName().equals(qName)) {
				skip = false;
			}
			break;
		}
		return returnValue;
	}
}