package servletPackage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import entity.Student;
import entity.dataMapper;

/**
 * Servlet implementation class studentServlet
 */
@WebServlet("/studentServlet")
@MultipartConfig
public class studentServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
	List<Student> student = new ArrayList<Student>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public studentServlet() {
        super();
        this.student.add(new Student("aaa","20"));
        this.student.add(new Student("bbb","50"));
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String json = new Gson().toJson(new dataMapper(this.student, "hello from server"));
		response.setContentType("application/json");
		response.getWriter().write(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nama = !request.getParameter("name").trim().isEmpty() ? request.getParameter("name").trim() : "";
		List<Student> foundStudent = this.student.stream().filter(s -> s.getName().equalsIgnoreCase(nama)).collect(Collectors.toList());
		String json = new Gson().toJson(foundStudent);
		response.setContentType("application/json");
		response.getWriter().write(json);
	}
}
