package consumer_b;

public class Body {
	String Payload;

	public String getPayload() {
		return Payload;
	}

	public void setPayload(String payload) {
		Payload = payload;
	}

	public Body(String payload) {
		super();
		Payload = payload;
	}
	public Body() {
		super();
		Payload = "Payload de ejemplo";
	}

	
}
