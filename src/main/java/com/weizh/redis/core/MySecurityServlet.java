package com.weizh.redis.core;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Permission;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MySecurityServlet extends HttpServlet {
    
    private static final long serialVersionUID = -8859624451333633952L;
    
    /**
     * Constructor of the object.
     */
    public MySecurityServlet() {
        super();
    }
    
    /**
     * Destruction of the servlet. <br>
     */
    public void destroy() {
        super.destroy();
    }
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
        out.println("<HTML>");
        out.println(" <HEAD><TITLE>Errot</TITLE></HEAD>");
        out.println(" <BODY>");
        out.println("Security denied!!!");
        out.println(" </BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();
    }
    
    /**
     * Initialization of the servlet. <br>
     * 
     * @throws ServletException
     *             if an error occurs
     */
    public void init() throws ServletException {
        SecurityManager originalSecurityManager = System.getSecurityManager();
        if (originalSecurityManager == null) {
            // 创建自己的SecurityManager
            SecurityManager sm = new SecurityManager() {
                
                private void check(Permission perm) {
                    // 禁止exec
                    if (perm instanceof java.io.FilePermission) {
                        String actions = perm.getActions();
                        if (actions != null && actions.contains("execute")) {
                            System.out.println("警告：>>检测到 weblogic 反序列化攻击...");
                            throw new SecurityException("execute denied!");
                        }
                    }
                    // 禁止设置新的SecurityManager，保护自己
                    if (perm instanceof java.lang.RuntimePermission) {
                        String name = perm.getName();
                        if (name != null && name.contains("setSecurityManager")) {
                            System.out.println("警告：<<检测到 weblogic 反序列化攻击...");
                            throw new SecurityException("System.setSecurityManager denied!");
                        }
                    }
                }
                
                public void checkPermission(Permission perm) {
                    check(perm);
                }
                
                public void checkPermission(Permission perm, Object context) {
                    check(perm);
                }
            };
            System.setSecurityManager(sm);
        }
    }
}
