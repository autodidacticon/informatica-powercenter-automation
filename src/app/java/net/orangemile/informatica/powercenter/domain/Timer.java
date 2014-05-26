package net.orangemile.informatica.powercenter.domain;

import net.orangemile.informatica.powercenter.domain.constant.TimerType;

public class Timer implements Cloneable {

	private TimerType timerType;
			
	public TimerType getTimerType() {
		return timerType;
	}
	public void setTimerType(TimerType timerType) {
		this.timerType = timerType;
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
