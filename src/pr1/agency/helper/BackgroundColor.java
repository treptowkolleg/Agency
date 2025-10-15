package pr1.agency.helper;

public enum BackgroundColor {
	LIGHT_GREY("47"), BLACK("40"), BLUE("44"), GREEN("42"), CYAN("46"), RED("41"), YELLOW("43"), MAGENTA("45"),
	NONE("49");

	private final String code;

	BackgroundColor(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}
}
