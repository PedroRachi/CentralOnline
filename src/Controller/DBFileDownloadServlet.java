package Controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * A servlet that retrieves a file from MySQL database and lets the client 
 * downloads the file.
 * @author www.codejava.net
 */
@WebServlet("/downloadFileServlet")
public class DBFileDownloadServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// size of byte buffer to send file
	private static final int BUFFER_SIZE = 4096;	
	
	// database connection settings
	private String dbURL = "jdbc:mysql://localhost:3306/CentralOnline";
	private String dbUser = "root";
	private String dbPass = "root";
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String pId = request.getParameter("id");
		
		// get upload id from URL's parameters
		//int uploadId = Integer.parseInt(request.getParameter("id"));
		
		Connection conn = null;	// connection to the database
		
		
		
		try {
			// connects to the database
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			conn = DriverManager.getConnection(dbURL, dbUser, dbPass);

			// queries the database
			String sql = "SELECT pdf FROM termo where id = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, Integer.parseInt(pId));

			ResultSet result = statement.executeQuery();
			if (result.next()) {
				// gets file name and file blob data
				//aqui é aonde ira pegar nome no  banco de dados e e ira renomear o arquivo
				String fileName = "termo";// = result.getString("Termo Empresa");
				Blob blob = result.getBlob("pdf");
				InputStream inputStream = blob.getBinaryStream();
				long fileLength = inputStream.available();
				
				System.out.println("fileLength = " + fileLength);

				ServletContext context = getServletContext();

				// sets MIME type for the file download
				//estava como INT passou a ser STRING para gerar o pdf
				String mimeType = context.getMimeType(fileName);
				
				if (mimeType == null) {			
					mimeType = "application/octet-stream";
				}				
				
				// set content properties and header attributes for the response
				response.setContentType(mimeType);
				//Para o arquivo ficar em pdf a variavel 'mimeType tem que estar como string 
				//logo tem que ter um cast no setContentLength se não, não funciona'
				response.setContentLength((int) fileLength);
				
				String headerKey = "Content-Disposition";
				//aqui vc ira configurar extencao tipo .pdf
				String headerValue = String.format("attachment; filename=\"%s\".pdf", fileName);
				response.setHeader(headerKey, headerValue);

				// writes the file to the client
				OutputStream outStream = response.getOutputStream();
				
				byte[] buffer = new byte[BUFFER_SIZE];
				int bytesRead = -1;
				
				while ((bytesRead = inputStream.read(buffer)) != -1) {
					outStream.write(buffer, 0, bytesRead);
				}
				
				inputStream.close();
				outStream.close();				
			} else {
				// no file found
				response.getWriter().print("File not found for the id: " /* uploadId*/);	
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			response.getWriter().print("SQL Error: " + ex.getMessage());
		} catch (IOException ex) {
			ex.printStackTrace();
			response.getWriter().print("IO Error: " + ex.getMessage());
		} finally {
			if (conn != null) {
				// closes the database connection
				try {
					conn.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}			
		}
	}
}