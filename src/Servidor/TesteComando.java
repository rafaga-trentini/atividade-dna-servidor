package Servidor;
//package Servidor.comandos;


public class TesteComando {
 
    public static void main(String[] args) {

//        Comando com = new Comando(new Sleep(null, null));
//        com.execute();
//
//        Comando com2 = new Comando(new New(null, null));
//        com2.execute();

        //TestExec t = new TestExec();
        //TestExec.execute("System.out.println('hello');");
        //exec("System.out.println('hello');");
        //Class.forName("Servidor.Comando").getConstructor().newInstance();
        // Get Class instance
        //Class<?> clazz = Class.forName("Servidor.Comando");

        // Get the private constructor.
        //Constructor<?> cons = clazz.getDeclaredConstructor();

        // Since it is private, make it accessible.
        //cons.setAccessible(true);

        // Create new object. 
        //Object obj = cons.newInstance();

        try {
            String name = "java.lang.String";
            String methodName = "toLowerCase";
  
            // get String Class
            Class cl = Class.forName(name);
  
            // get the constructor with one parameter
            java.lang.reflect.Constructor constructor =
               cl.getConstructor
                 (new Class[] {String.class});
  
            // create an instance
            Object invoker =
               constructor.newInstance
                 (new Object[]{"REAL'S HOWTO"});
  
            // the method has no argument
            Class  arguments[] = new Class[] { };
  
            // get the method
            java.lang.reflect.Method objMethod =
               cl.getMethod(methodName, arguments);
  
            // convert "REAL'S HOWTO" to "real's howto"
            Object result =
               objMethod.invoke
                 (invoker, (Object[])arguments);
  
            System.out.println(result);
          }
          catch (Exception e) {
              e.printStackTrace();
          }
    }
}
