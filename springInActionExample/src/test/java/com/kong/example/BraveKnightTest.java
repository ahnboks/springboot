package com.kong.example;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mockito.Mockito.*;

import com.kong.knights.BraveKnight;
import com.kong.knights.Quest;

public class BraveKnightTest {
	@Autowired
	Quest mockQuest;
	
	@Autowired
	BraveKnight knight;
	
	@Test
	public void knightShouldEmbarkOnQuest() {
		mockQuest = mock(Quest.class);
		knight = new BraveKnight(mockQuest);
		knight.embarkOnQuest();
		verify(mockQuest, times(1)).embark();
	}
}
