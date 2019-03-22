import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DataProcessing extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            //reading the values
            String s1=request.getParameter("t1");
            String s2=request.getParameter("t2");
            
            //Before Processing Validating Values
            boolean validName=true;
            boolean validAge=true;
            
            int length=s1.length();
            if(length==0){
                validName=false;
                request.setAttribute("errName", "Name Cant Be Blank");
            }
            
            try{
                int age=Integer.parseInt(s2);
            }catch(NumberFormatException e){
                request.setAttribute("errAge", "Age Must Be A Number");
                validAge=false;
            }
            
            if(validName==false || validAge==false){
                RequestDispatcher rd=request.getRequestDispatcher("dataentry.jsp");
                rd.forward(request, response);
                //response.sendRedirect("dataentry.jsp");
            }
            
            
            
            
            //processing the values
            out.println("Your Name : "+s1+"<br>");
            out.println("Your Age  : "+s2);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
