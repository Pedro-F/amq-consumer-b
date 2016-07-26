package consumer_b;

/**
 * Body of Evento class
 * @author pedro.alonso.garcia
 *
 */
public class Body {
	String Payload;

	public Body(String payload) {
		super();
		Payload = payload;
	}
	
	public Body() {
		super();
		Payload = "Payload de ejemplo";
	}
	
	public String getPayload() {
		return Payload;
	}

	public void setPayload(String payload) {
		Payload = payload;
	}
	
}
