package com.kong.knights;

public class BraveKnight implements Knight{
	  private Quest quest;

	  public BraveKnight(Quest quest) {
	    this.quest = quest;
	  }

	  public void embarkOnQuest() {
	    quest.embark();
	    System.out.println("embark 테스트");
	  }
}
