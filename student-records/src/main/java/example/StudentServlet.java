package example;

import com.fasterxml.jackson.databind.ObjectMapper;
import example.model.StudentEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

@WebServlet("/students")
public class StudentServlet extends HttpServlet {

    private StudentDao dao;
    private ObjectMapper mapper;

    @Override
    public void init() throws ServletException {
        dao = new StudentDao();
        mapper = new ObjectMapper(); // Jackson serializer instance
    }

    // GET /students?id=1
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        String idParam = req.getParameter("id");
        if (idParam == null || idParam.trim().isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            out.println("{\"error\": \"Missing required 'id' parameter\"}");
            return;
        }

        try {
            long id = Long.parseLong(idParam);
            Optional<StudentEntity> studentOpt = dao.findById(id);

            if (studentOpt.isEmpty()) {
                resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
                out.println("{\"error\": \"Student with ID " + id + " does not exist\"}");
                return;
            }

            // Convert Java Object -> JSON String automatically
            String jsonOutput = mapper.writeValueAsString(studentOpt.get());
            resp.setStatus(HttpServletResponse.SC_OK);
            out.println(jsonOutput);

        } catch (NumberFormatException e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            out.println("{\"error\": \"Invalid ID format\"}");
        } catch (Exception e) {
            log("Database query failure", e);
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            out.println("{\"error\": \"Database processing error\"}");
        }
    }

    // POST /students
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        try {
            // Reads raw JSON body directly from input stream into StudentEntity
            StudentEntity incomingStudent = mapper.readValue(req.getInputStream(), StudentEntity.class);

            if (incomingStudent.getName() == null || incomingStudent.getEmail() == null) {
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                out.println("{\"error\": \"Name and Email fields are required in JSON body\"}");
                return;
            }

            long newId = dao.insert(incomingStudent.getName(), incomingStudent.getEmail());
            Optional<StudentEntity> newStudent = dao.findById(newId);

            resp.setStatus(HttpServletResponse.SC_CREATED);
            if (newStudent.isPresent()) {
                out.println(mapper.writeValueAsString(newStudent.get()));
            }
        } catch (Exception e) {
            log("JSON parsing or database insert failure", e);
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            out.println("{\"error\": \"Invalid JSON body or processing error\"}");
        }
    }
    // PUT /students?id=1&email=newemail@example.com
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        String idParam = req.getParameter("id");
        if (idParam == null || idParam.trim().isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            out.println("{\"error\": \"Missing required 'id' parameter\"}");
            return;
        }

        try {
            long id = Long.parseLong(idParam);

            // Read incoming JSON payload
            StudentEntity incomingData = mapper.readValue(req.getInputStream(), StudentEntity.class);

            if (incomingData.getEmail() == null || incomingData.getEmail().trim().isEmpty()) {
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                out.println("{\"error\": \"Email field is required in JSON body\"}");
                return;
            }

            boolean updated = dao.updateEmail(id, incomingData.getEmail());

            if (updated) {
                Optional<StudentEntity> updatedStudent = dao.findById(id);
                resp.setStatus(HttpServletResponse.SC_OK);
                if (updatedStudent.isPresent()) {
                    out.println(mapper.writeValueAsString(updatedStudent.get()));
                }
            } else {
                resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
                out.println("{\"error\": \"Student with ID " + id + " does not exist\"}");
            }
        } catch (NumberFormatException e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            out.println("{\"error\": \"Invalid ID format\"}");
        } catch (Exception e) {
            log("Database update failure", e);
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            out.println("{\"error\": \"Could not update student\"}");
        }
    }
    // DELETE /students?id=1
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        String idParam = req.getParameter("id");
        if (idParam == null) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            out.println("{\"error\": \"Missing required 'id' parameter\"}");
            return;
        }

        try {
            long id = Long.parseLong(idParam);
            boolean deleted = dao.deleteById(id);

            if (deleted) {
                resp.setStatus(HttpServletResponse.SC_OK);
                out.println("{\"message\": \"Deleted student with ID " + id + "\"}");
            } else {
                resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
                out.println("{\"error\": \"Student with ID " + id + " does not exist\"}");
            }
        } catch (NumberFormatException e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            out.println("{\"error\": \"Invalid ID format\"}");
        } catch (Exception e) {
            log("Database delete failure", e);
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            out.println("{\"error\": \"Could not delete student\"}");
        }
    }
}