package Servidor;

import java.io.BufferedReader;

import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.Collection;

public class TestExec {

    /**
     * Execute a system command and return the output in a String array.
     *
     * @param command the system command and arguments
     * @return the system command output
     * @throws Exception if the command fails to execute.
     */
    public static Collection<String> execute(String command)
            throws Exception {
        Process p = Runtime.getRuntime().exec(command);
        Collection<String> output = new ArrayList<>();
        try (BufferedReader input = new BufferedReader(
                new InputStreamReader(p.getInputStream()))) {
            String line;
            while ((line = input.readLine()) != null) {
                output.add(line.trim());
            }
        }
        return output;
    }
}

