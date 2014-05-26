package net.orangemile.informatica.powercenter.domain;

import net.orangemile.informatica.powercenter.domain.constant.NullCharType;

public class FlatFile implements Cloneable {

	private String fileName;
	private String fileType;
	private String delimited;
	private String delimiters;
	private String delimitersInBinary;
	private String quoteCharacter;
	private String nullCharacter;
	private NullCharType nullCharType;
	private Boolean stageFileReInit;
	private Boolean stageFilePersist;
	private String repeatable;
	private String consecDelimitersAsOne;
	private String striptTrailingBlanks;
	private String padBytes;
	private String skipLeadingBytes;
	private String skipTrailingBytes;
	private String linesSequential;
	private String keepEscapeChar;
	private String shiftSensitiveData;
	private String escapeCharacter;
	private String skipRows;
	private String codePage;
	
	public String getCodePage() {
		return codePage;
	}
	public void setCodePage(String codePage) {
		this.codePage = codePage;
	}
	public String getConsecDelimitersAsOne() {
		return consecDelimitersAsOne;
	}
	public void setConsecDelimitersAsOne(String consecDelimitersAsOne) {
		this.consecDelimitersAsOne = consecDelimitersAsOne;
	}
	public String getDelimited() {
		return delimited;
	}
	public void setDelimited(String delimited) {
		this.delimited = delimited;
	}
	public String getDelimiters() {
		return delimiters;
	}
	public void setDelimiters(String delimiters) {
		this.delimiters = delimiters;
	}
	public String getDelimitersInBinary() {
		return delimitersInBinary;
	}
	public void setDelimitersInBinary(String delimitersInBinary) {
		this.delimitersInBinary = delimitersInBinary;
	}
	public String getEscapeCharacter() {
		return escapeCharacter;
	}
	public void setEscapeCharacter(String escapeCharacter) {
		this.escapeCharacter = escapeCharacter;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public String getKeepEscapeChar() {
		return keepEscapeChar;
	}
	public void setKeepEscapeChar(String keepEscapeChar) {
		this.keepEscapeChar = keepEscapeChar;
	}
	public String getLinesSequential() {
		return linesSequential;
	}
	public void setLinesSequential(String linesSequential) {
		this.linesSequential = linesSequential;
	}
	public String getNullCharacter() {
		return nullCharacter;
	}
	public void setNullCharacter(String nullCharacter) {
		this.nullCharacter = nullCharacter;
	}
	public NullCharType getNullCharType() {
		return nullCharType;
	}
	public void setNullCharType(NullCharType nullCharType) {
		this.nullCharType = nullCharType;
	}
	public String getPadBytes() {
		return padBytes;
	}
	public void setPadBytes(String padBytes) {
		this.padBytes = padBytes;
	}
	public String getQuoteCharacter() {
		return quoteCharacter;
	}
	public void setQuoteCharacter(String quoteCharacter) {
		this.quoteCharacter = quoteCharacter;
	}
	public String getRepeatable() {
		return repeatable;
	}
	public void setRepeatable(String repeatable) {
		this.repeatable = repeatable;
	}
	public String getShiftSensitiveData() {
		return shiftSensitiveData;
	}
	public void setShiftSensitiveData(String shiftSensitiveData) {
		this.shiftSensitiveData = shiftSensitiveData;
	}
	public String getSkipLeadingBytes() {
		return skipLeadingBytes;
	}
	public void setSkipLeadingBytes(String skipLeadingBytes) {
		this.skipLeadingBytes = skipLeadingBytes;
	}
	public String getSkipRows() {
		return skipRows;
	}
	public void setSkipRows(String skipRows) {
		this.skipRows = skipRows;
	}
	public String getSkipTrailingBytes() {
		return skipTrailingBytes;
	}
	public void setSkipTrailingBytes(String skipTrailingBytes) {
		this.skipTrailingBytes = skipTrailingBytes;
	}
	public String getStriptTrailingBlanks() {
		return striptTrailingBlanks;
	}
	public void setStriptTrailingBlanks(String striptTrailingBlanks) {
		this.striptTrailingBlanks = striptTrailingBlanks;
	}
	
	public boolean isStageFilePersist() {
		return stageFilePersist;
	}
	public void setStageFilePersist(boolean stageFilePersist) {
		this.stageFilePersist = stageFilePersist;
	}
	public Boolean isStageFileReInit() {
		return stageFileReInit;
	}
	public void setStageFileReInit(Boolean stageFileReInit) {
		this.stageFileReInit = stageFileReInit;
	}
	@Override
	public Object clone() {
		try {
			return super.clone();
		} catch ( CloneNotSupportedException e ) {
			throw new RuntimeException(e);
		}
	}	
}
