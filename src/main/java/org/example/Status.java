package org.example;

public enum Status {
    BORROWED {
    	public String toString() {
    		return "Prestado";
    	}
    }, 
    OVERDUE {
    	public String toString() {
    		return "Atrasado";
    	}
    },
    LOST {
    	public String toString() {
    		return "Perdido";
    	}
    },
    LIBRARY {
    	public String toString() {
    		return "En Librería";
    	}
    }

};
