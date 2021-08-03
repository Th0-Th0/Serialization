package com.tho.serialization.serializer;

import java.io.IOException;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XmlDomSerializer extends AbstractKeyValueSerializer<Element> {

	private DocumentBuilder loader;
	private Document document;

	private final SAXBuilder saxBuilder;
	private Transformer transformer;
	private StringWriter writer;

	public XmlDomSerializer() {
		this.saxBuilder = new SAXBuilder();
		try {
			this.loader = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			this.document = this.loader.newDocument();
			this.transformer = TransformerFactory.newInstance().newTransformer();
			this.transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
			this.transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			this.transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "3");
			this.writer = new StringWriter();
		} catch (final ParserConfigurationException e) {
			e.printStackTrace();
		} catch (final TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (final TransformerFactoryConfigurationError e) {
			e.printStackTrace();
		}
	}

	@Override
	public void setSerializedData(final String inputData) {
		try {
			this.document = (Document) this.saxBuilder.build(inputData);
		} catch (final JDOMException e) {
			e.printStackTrace();
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getSerializedData() {
		try {
			this.transformer.transform(new DOMSource(this.document), new StreamResult(this.writer));
		} catch (final TransformerException e) {
			e.printStackTrace();
		}

		return this.writer.toString();
	}

	@Override
	public void prepareToSerialize() {
		this.currentObject = null;
	}

	@Override
	public void prepareToDeserialize() {
		this.currentObject = null;
	}

	@Override
	protected Element getNewObject() {
		return this.document == null ? null : this.document.createElement("uninitializedXmlElement");
	}

	@Override
	protected void put(final String name, final Element object) {
		this.document.renameNode(object, null, name);
		if (this.currentObject == null) {
			this.document.appendChild(object);
		} else {
			this.currentObject.appendChild(object);
		}
	}

	@Override
	protected Element get(final String name) {
		final Element element;
		if (this.currentObject == null) {
			element = (Element) this.document.getElementsByTagName(name).item(0);
		} else {
			element = (Element) this.currentObject.getElementsByTagName(name).item(0);
		}
		return element;
	}

	private void putXmlElement(final String name, final String value) {
		final Element element = this.document.createElement(name);
		element.appendChild(this.document.createTextNode(String.valueOf(value)));
		if (this.currentObject == null) {
			this.currentObject = element;
			this.document.appendChild(element);
		} else {
			this.currentObject.appendChild(element);
		}
	}

	private String getXmlElement(final String name) {
		return this.currentObject.getElementsByTagName(name).item(0).getTextContent();
	}

	@Override
	public void putBoolean(final String name, final boolean value) {
		putXmlElement(name, String.valueOf(value));
	}

	@Override
	public boolean getBoolean(final String name) {
		return Boolean.valueOf(getXmlElement(name));
	}

	@Override
	public void putByte(final String name, final byte value) {
		putXmlElement(name, String.valueOf(value));
	}

	@Override
	public byte getByte(final String name) {
		return Byte.valueOf(getXmlElement(name));
	}

	@Override
	public void putChar(final String name, final char value) {
		putXmlElement(name, String.valueOf(value));
	}

	@Override
	public char getChar(final String name) {
		return getXmlElement(name).charAt(0);
	}

	@Override
	public void putShort(final String name, final short value) {
		putXmlElement(name, String.valueOf(value));
	}

	@Override
	public short getShort(final String name) {
		return Short.valueOf(getXmlElement(name));
	}

	@Override
	public void putLong(final String name, final long value) {
		putXmlElement(name, String.valueOf(value));
	}

	@Override
	public long getLong(final String name) {
		return Long.valueOf(getXmlElement(name));
	}

	@Override
	public void putFloat(final String name, final float value) {
		putXmlElement(name, String.valueOf(value));
	}

	@Override
	public float getFloat(final String name) {
		return Float.valueOf(getXmlElement(name));
	}

	@Override
	public void putDouble(final String name, final double value) {
		putXmlElement(name, String.valueOf(value));
	}

	@Override
	public double getDouble(final String name) {
		return Double.valueOf(getXmlElement(name));
	}

	@Override
	public void putString(final String name, final String value) {
		putXmlElement(name, value);
	}

	@Override
	public String getString(final String name) {
		return getXmlElement(name);
	}

	@Override
	public void putInt(final String name, final int value) {
		putXmlElement(name, String.valueOf(value));
	}

	@Override
	public int getInt(final String name) {
		return Integer.valueOf(getXmlElement(name));
	}
}
