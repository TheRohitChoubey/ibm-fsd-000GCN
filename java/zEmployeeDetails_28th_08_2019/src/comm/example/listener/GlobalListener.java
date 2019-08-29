package comm.example.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class GlobalListener
 *
 */
@WebListener
public class GlobalListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public GlobalListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    	System.out.println("GLOBAL CONTEXT DESTROYED");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    	System.out.println("GLOBAL CONTEXT INITIALIZED");
    	arg0.getServletContext().setAttribute("USERNAME", "admin");
    	arg0.getServletContext().setAttribute("PASSWORD", "admin");
    	System.out.println("Setting username and password.");
    }
	
}