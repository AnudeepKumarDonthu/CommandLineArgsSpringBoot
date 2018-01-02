/**
 * 
 */
package com.commandlineargs.springboot;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author AnudeepKumar
 *
 */
@Component
public class CommandLineRunnerImpl implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
		String commandData= args[0];
		System.out.println(commandData);
		
	}

}
