package com.kong.knights;

import java.io.PrintStream;

public class SlayDragonQuest implements Quest{
	private PrintStream stream;
	
	public SlayDragonQuest(PrintStream stream) {
		this.stream=stream;
	}
	
	public void embark() {
		stream.println("Embarking on quest to slay the dragon!");
	}
}


//<bean id="minstrel" class="sia.knights.Minstrel">
//  <constructor-arg ref="fakePrintStream" />
//</bean>
//
//<bean id="fakePrintStream" class="sia.knights.FakePrintStream" />
//
//<aop:config>
//  <aop:aspect ref="minstrel">
//    <aop:pointcut id="embark"
//        expression="execution(* *.embarkOnQuest(..))"/>
//      
//    <aop:before pointcut-ref="embark" 
//        method="singBeforeQuest"/>
//
//    <aop:after pointcut-ref="embark" 
//        method="singAfterQuest"/>
//  </aop:aspect>
//</aop:config>
