package data

import books.Book

class Data {    
	
	static def books = [        
		[title: "Specification by Example", author: "Gojko Adzic"]    
	]    
	
	static public def findByTitle (String titleToFind) {        
		books.find { book ->            
			book.title == titleToFind        
		}    
	}    
	
	static void clearBooks () {        
		Book.findAll()*.delete (flush: true)    
	} 

}
