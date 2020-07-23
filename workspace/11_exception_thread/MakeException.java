class MakeException extends Exception{		//개발자가 만든 Exception클래스
	private String errorMsg;

	public MakeException(){}

	public MakeException(String errorMsg){
		this.errorMsg = errorMsg;
	}

	@Override
	public String toString(){
		//return getClass() + ":" + errorMsg;
		return errorMsg;
	}
}