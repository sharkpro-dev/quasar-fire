package com.quasarFire.businessLogic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.quasarFire.businessLogic.exception.IncompleteMessageException;

@SpringBootTest
public class MessageFragmentJoinerTests {

    
    @Test
    public void whenInputIsTrivial_shouldJoinCorrectly() {
    	String[][] messages = { 
			{"a", "b"}, 
			{"" , ""} 
    	};
    	assertThat(MessageFragmentJoiner.join(messages))
          .isEqualTo("a b");
     }
    
    @Test
    public void whenInputIsSimple_shouldJoinCorrectly() {
    	String[][] messages = { 
			{"a", "",}, 
			{"" , "b"} 
    	};
    	assertThat(MessageFragmentJoiner.join(messages))
          .isEqualTo("a b");
     }

    
    @Test
    public void whenInputIsComplex_shouldJoinCorrectly() {
    	String[][] messages = { 
			{"", "", "", "", ""}, 
			{"" , "b", "", "", ""},
			{"" , "", "", "d", "e"},
			{"" , "b", "c", "", ""},
			{"a" , "", "c", "", ""},
    	};
    	assertThat(MessageFragmentJoiner.join(messages))
          .isEqualTo("a b c d e");
     }
    
    
    @Test
    public void whenInputIsIncompleteWithLastWordMissing_shouldThrowException() {
    	String[][] messages = { 
			{"a", "",}, 
			{"" , ""} 
    	};
    	
        assertThatThrownBy(() -> MessageFragmentJoiner.join(messages)).isInstanceOf(IncompleteMessageException.class);
        
     }
    
    @Test
    public void whenInputIsIncompleteWithFirstWordMissing_shouldThrowException() {
    	String[][] messages = { 
			{"", "",}, 
			{"" , "b"} 
    	};
    	
        assertThatThrownBy(() -> MessageFragmentJoiner.join(messages)).isInstanceOf(IncompleteMessageException.class);
        
     }
}


