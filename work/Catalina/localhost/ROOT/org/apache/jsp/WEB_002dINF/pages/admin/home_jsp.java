/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.62
 * Generated at: 2023-12-29 20:47:17 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.pages.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1695037403474L));
    _jspx_dependants.put("jar:file:/C:/Users/HP/.m2/repository/javax/servlet/jstl/1.2/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153359882000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!doctype html>\n");
      out.write("<html lang=\"en\" xmlns:th=\"http://www.thymeleaf.org\">\n");
      out.write("<head>\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("<meta name=\"viewport\"\n");
      out.write("	content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n");
      out.write("<link rel=\"stylesheet\"\n");
      out.write("	href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css\"\n");
      out.write("	integrity=\"sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh\"\n");
      out.write("	crossorigin=\"anonymous\">\n");
      out.write("<link rel=\"stylesheet\"\n");
      out.write("	href=\"https://use.fontawesome.com/releases/v5.7.0/css/all.css\"\n");
      out.write("	integrity=\"sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ\"\n");
      out.write("	crossorigin=\"anonymous\">\n");
      out.write("<title>Admin Home</title>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body class=\"bg-dark\">\n");
      out.write("	<nav class=\"navbar navbar-expand-lg navbar-dark bg-dark\">\n");
      out.write("		<div class=\"container-fluid\">\n");
      out.write("			<a class=\"navbar-brand\" href=\"#\"> <img\n");
      out.write("				src=\"../static/images/logo.png\" width=\"auto\" height=\"40\"\n");
      out.write("				class=\"d-inline-block align-top\" alt=\"\" />\n");
      out.write("			</a>\n");
      out.write("			<button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\"\n");
      out.write("				data-target=\"#navbarSupportedContent\"\n");
      out.write("				aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\"\n");
      out.write("				aria-label=\"Toggle navigation\">\n");
      out.write("				<span class=\"navbar-toggler-icon\"></span>\n");
      out.write("			</button>\n");
      out.write("\n");
      out.write("			<div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n");
      out.write("				<ul class=\"navbar-nav mr-auto\"></ul>\n");
      out.write("				<ul class=\"navbar-nav\">\n");
      out.write("<li class=\"nav-item active\"><a class=\"nav-link\" href=\"/admin/home/userList\">Manage User</a></li>\n");
      out.write("\n");
      out.write("					<li class=\"nav-item active\"><a class=\"nav-link\" href=\"/\">Exit</a></li>\n");
      out.write("				</ul>\n");
      out.write("\n");
      out.write("			</div>\n");
      out.write("		</div>\n");
      out.write("	</nav>\n");
      out.write("	<div class=\"jumbotron text-center\">\n");
      out.write("		<h1 class=\"display-4\">Welcome Back, Admin</h1><hr>\n");
      out.write("		<img src=\"../resources/img/admin/chaoadmin.png\" />\n");
      out.write("	</div><br>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("	<script src=\"https://code.jquery.com/jquery-3.4.1.slim.min.js\"\n");
      out.write("		integrity=\"sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n\"\n");
      out.write("		crossorigin=\"anonymous\"></script>\n");
      out.write("	<script\n");
      out.write("		src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js\"\n");
      out.write("		integrity=\"sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo\"\n");
      out.write("		crossorigin=\"anonymous\"></script>\n");
      out.write("	<script\n");
      out.write("		src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js\"\n");
      out.write("		integrity=\"sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6\"\n");
      out.write("		crossorigin=\"anonymous\"></script>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
