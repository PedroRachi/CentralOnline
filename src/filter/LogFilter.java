package filter;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

import Model.Login;
import Model.PreCadastro;
import Model.Usuario;
import utils.Log;

@WebFilter("/*")
public class LogFilter implements Filter {

	FilterConfig filterConfig = null;

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// place your code here
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		Object usuario = null;

		if (session.getAttribute("logado") instanceof Login) {
			usuario = (Login) session.getAttribute("logado");

		} else if (session.getAttribute("logado") instanceof PreCadastro) {
			usuario = (PreCadastro) session.getAttribute("logado");
		}else if (session.getAttribute("logado") instanceof Usuario) {
			usuario = (Usuario) session.getAttribute("logado");
		// Login usuario = (Login) session.getAttribute("logado");
		}

		String comando = req.getParameter("command");
		if (comando == null) {
			comando = req.getRequestURI();
		}
		Calendar timestamp = Calendar.getInstance();
		String textoLog = "";
		ServletContext servletContext = filterConfig.getServletContext();
		String contextPath = servletContext.getRealPath(File.separator);

		if (usuario == null) {
			textoLog = String.format("[%1$tA, %1$tB %1$td, %1$tY %1$tZ %1$tI:%1$tM:%1$tS:%1$tL %tp] %s\n", timestamp,
					comando);
		} else {
			if (usuario instanceof Login)
				textoLog = String.format("[%1$tA, %1$tB %1$td, %1$tY %1$tZ %1$tI:%1$tM:%1$tS:%1$tL %tp] %s -> %s\n",
						timestamp, ((Login) usuario).getUsername(), comando);
			if(usuario instanceof PreCadastro)
				textoLog = String.format("[%1$tA, %1$tB %1$td, %1$tY %1$tZ %1$tI:%1$tM:%1$tS:%1$tL %tp] %s -> %s\n",
						timestamp, ((PreCadastro) usuario).getCnpf_cnpj(), comando);
		}
		synchronized (textoLog) {
			Log arqLog = new Log();
			// arqLog.abrir(Log.NOME);
			arqLog.abrir(contextPath + File.separator + "log" + File.separator + Log.NOME);
			arqLog.escrever(textoLog);
			arqLog.fechar();
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		this.filterConfig = fConfig;
	}

}
