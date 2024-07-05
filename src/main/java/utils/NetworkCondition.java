package utils;

public enum NetworkCondition {

	TWO_G("2G"), THREE_G("3G"), FOUR_G("4G"), FIVE_G("5G");

	private String value;

	NetworkCondition(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
