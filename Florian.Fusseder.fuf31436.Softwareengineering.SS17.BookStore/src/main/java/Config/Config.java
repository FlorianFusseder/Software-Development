/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;

/**
 *
 * @author Florian Fußeder
 */
public class Config {
	
	public enum RunOption{
		Test,
		Productiv
	}
	
	private static RunOption option = RunOption.Test;
	private static String myIban = "1234567489";

	public static RunOption getOption() {
		return option;
	}

	public static String getMyIban() {
		return myIban;
	}
	
	
	
}