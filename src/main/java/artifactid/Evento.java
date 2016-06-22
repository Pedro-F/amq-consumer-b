package artifactid;


public class Evento {
	
	
	Header header;
	Body body;
	
	public Header getHeader() {
		return header;
	}
	public void setHeader(Header header) {
		this.header = header;
	}
	public Body getBody() {
		return body;
	}
	public void setBody(Body body) {
		this.body = body;
	}
	
	
	
	public Evento(Header header, Body body) {
		super();
		this.header = header;
		this.body = body;
	}
	
	public Evento() {
		super();
		header = new Header();
		body = new Body();
	}

	
	
}
