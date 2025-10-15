package pr1.agency.core;

public enum NumeralSystem {
	
	BINARY(2, "0b", "b"),
    OCTAL(8, "0o", "o"),
    DECIMAL(10, "", ""),
    HEXADECIMAL(16, "0x", "h");

    private final int base;
    private final String prefix;  // z. B. "0x" für Hex
    private final String suffix;  // z. B. "h" in manchen Assemblern

    NumeralSystem(int base, String prefix, String suffix) {
        this.base = base;
        this.prefix = prefix;
        this.suffix = suffix;
    }

    public int getBase() {
        return base;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getSuffix() {
        return suffix;
    }

}
