package Controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import Command.URLEnviarParametros;
import Model.Empresa;
import Model.Usuario;
import Service.EmpresaService;

@WebServlet("/uploadServletADM")
@MultipartConfig(maxFileSize = 16177215) // upload file's size up to 16MB
public class DFileInsertFeitoPeloADM extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// database connection settings
	private String dbURL = "jdbc:mysql://localhost:3306/CentralOnline";
	private String dbUser = "root";
	private String dbPass = "root";
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		Empresa usua = (Empresa) session.getAttribute("empresa_logada");
		Usuario usua1 = (Usuario) session.getAttribute("logado");
		
		URLEnviarParametros enviar = new URLEnviarParametros();
		
		
		
		String pId = request.getParameter("empresaCNPJ");

		InputStream inputStream = null; // input stream of the upload file
		// Empresa empresa = null;
		// String pEmpresaCNPJ = request.getParameter("empresaCNPJ");

		// emp.setEmpresaCNPJ(pEmpresaCNPJ);

		EmpresaService es = new EmpresaService();

		// obtains the upload file part in this multipart request

		Part filePart = request.getPart("photo");
		if (filePart != null) {
			// prints out some information for debugging

			//System.out.println(filePart.getSize());
			//System.out.println(filePart.getContentType());

			// obtains input stream of the upload file
			inputStream = filePart.getInputStream();

		}

		Connection conn = null; // connection to the database
		String message = null; // message will be sent back to client

		try {
			// connects to the database
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			conn = DriverManager.getConnection(dbURL, dbUser, dbPass);

			// constructs SQL statement
			String sql = "INSERT into termo(documento,pdf) values (?,?)";         //empresaCNPJ = ?";

			PreparedStatement statement = conn.prepareStatement(sql);
			// Empresa emp = new Empresa();

			if (inputStream != null) {
				// fetches input stream of the upload file for the blob column
				statement.setString(1, pId);
				statement.setBlob(2, inputStream);
				
				//statement.setString(2, usua1.getDocumentoEmpresa());
			}

			// sends the statement to the database server
			int row = statement.executeUpdate();
			if (row > 0) {
				message = "Upload efetuado com sucesso!!";
			}
		} catch (SQLException ex) {
			message = "ERROR: " + ex.getMessage();
			ex.printStackTrace();
		} finally {
			if (conn != null) {
				// closes the database connection
				try {
					conn.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
			// sets the message in request scope
			request.setAttribute("usuario", usua);
			request.setAttribute("Message", message);

			// forwards to the message page

			getServletContext().getRequestDispatcher("/Message.jsp").forward(request, response);
		}
	}
}