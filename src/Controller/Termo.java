/*package Controller;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

//import dao.TermoEscritoDAO;

 
@WebServlet("/uploadServlet")
@MultipartConfig(maxFileSize = 16177215)    // upload file's size up to 16MB
public class Termo extends HttpServlet {
     
    private String dbURL = "jdbc:mysql://localhost:3306/bancoprojeto";
    private String dbUser = "root";
    private String dbPass = "654321";

    private static final int BUFFER_SIZE = 4096; 
    	protected void doGet(HttpServletRequest request,
                HttpServletResponse response) throws ServletException, IOException {
    		String retorno = (String) request.getParameter("retorno");
            int tipo = Integer.parseInt(request.getParameter("tipo"));
            int idtipo = Integer.parseInt(request.getParameter("idtipo"));
            Connection conn = null;
             
            try {
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
     
                String sql = "SELECT * FROM termo where tipo = ? && idtipo = ?";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setInt(1, tipo);
                statement.setInt(2, idtipo);
                ResultSet result = statement.executeQuery();
                if (result.next()) {
                    String fileName = result.getString("texto");
                    Blob blob = result.getBlob("arquivo");
                    InputStream inputStream = blob.getBinaryStream();
                    int fileLength = inputStream.available();
                     
                    System.out.println("fileLength = " + fileLength);
     
                    ServletContext context = getServletContext();
     
                    String mimeType = context.getMimeType(fileName);
                    if (mimeType == null) {        
                        mimeType = "application/octet-stream";
                    }              
                     
                    response.setContentType(mimeType);
                    response.setContentLength(fileLength);
                    String headerKey = "Content-Disposition";
                    String headerValue = String.format("attachment; filename=\"%s\".pdf", fileName);
                    response.setHeader(headerKey, headerValue);
     
                    OutputStream outStream = response.getOutputStream();
                     
                    byte[] buffer = new byte[BUFFER_SIZE];
                    int bytesRead = -1;
                     
                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outStream.write(buffer, 0, bytesRead);
                    }
                     
                    inputStream.close();
                    outStream.close();             
                } else {
                	RequestDispatcher view =  request.getRequestDispatcher(retorno);
                    view.forward(request, response);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                response.getWriter().print("SQL Error: " + ex.getMessage());
            } catch (IOException ex) {
                ex.printStackTrace();
                response.getWriter().print("IO Error: " + ex.getMessage());
            } finally {
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }          
            }
        }
	

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
    	String retorno = (String) request.getParameter("retorno");
        // gets values of text fields
       String tipo = request.getParameter("tipo");
       String idtipo = request.getParameter("idtipo");
         
        InputStream inputStream = null; // input stream of the upload file
         
        // obtains the upload file part in this multipart request
        Part filePart = request.getPart("arquivo");
        if (filePart != null) {
            // prints out some information for debugging
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());
             
            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();
        }
         
        Connection conn = null; // connection to the database
        String message = null;  // message will be sent back to client
         
        try {
            // connects to the database
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
 
           // TermoEscritoDAO termoescrito = new TermoEscritoDAO();
         //   int i = termoescrito.buscaridpdf(Integer.parseInt(tipo), Integer.parseInt(idtipo));
            // constructs SQL statement
         //   String sql = "update termo set texto = ?, arquivo = ? where id = "+i+";";
           // PreparedStatement statement = conn.prepareStatement(sql);
 
            if (inputStream != null) {
                // fetches input stream of the upload file for the blob column
              //  statement.setBlob(2, inputStream);
              //  statement.setString(1, "Tipo: "+filePart.getContentType()+" Nome: "+filePart.getName()+ " Tamanho: "+ filePart.getSize());
            }
 
            // sends the statement to the database server
         //   int row = statement.executeUpdate();
          //  if (row > 0) {
            //    message = "File uploaded and saved into database";
        //    }
   //     } catch (SQLException ex) {
         //   message = "ERROR: " + ex.getMessage();
        //    ex.printStackTrace();
      //  } finally {
         //   if (conn != null) {
                // closes the database connection
           //     try {
          //          conn.close();
             //   } catch (SQLException ex) {
               //     ex.printStackTrace();
              //  }
          //  }
            // sets the message in request scope
          //  request.setAttribute("Message", message);
         //   RequestDispatcher view =  request.getRequestDispatcher(retorno);
        //    view.forward(request, response);
            // forwards to the message page
          //  getServletContext().getRequestDispatcher(retorno).forward(request, response);
      //  }
   // }
//}*/