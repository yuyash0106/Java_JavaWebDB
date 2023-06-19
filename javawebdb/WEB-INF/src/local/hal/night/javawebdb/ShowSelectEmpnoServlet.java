package local.hal.night.javawebdb;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * JavaWebDB Lesson Practice Src01
 *
 * 従業員番号表示。
 *
 * @author yuyas
 */
@WebServlet(name = "ShowSelectEmpnoServlet", urlPatterns = { "/showSelectEmpno" })
public class ShowSelectEmpnoServlet extends HttpServlet {
	/**
	 * DB接続URLを表す定数フィールド。フィールド。
	 */
	private static final String DB_URL = "jdbc:mysql://localhost/javawebdb?useUnicode=true&characterEncoding=utf8";
	/**
	 * DB接続ユーザー名を表す定数フィールド。
	 */
	private static final String USERNAME = "scott";
	/**
	 * DB接続パスワードを表す定数フィールド
	 */
	private static final String PASSWORD = "tiger";

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jspPath = "/selectEmpno.jsp";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Map<Integer, Emp> empList = new LinkedHashMap<>();
		String sql = "SELECT * FROM emp ORDER BY empno";
		try {
			con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				Integer empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				Integer mgr = rs.getInt("mgr");
				Date hiredate = rs.getDate("hiredate");
				Double sal = rs.getDouble("sal");
				Double comm = rs.getDouble("comm");
				Integer deptno = rs.getInt("deptno");

				Emp emp = new Emp();
				emp.setEmpno(empno);
				emp.setEname(ename);
				emp.setJob(job);
				emp.setMgr(mgr);
				emp.setHiredate(hiredate);
				emp.setSal(sal);
				emp.setComm(comm);
				emp.setDeptno(deptno);
				empList.put(empno, emp);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
			close(con);
		}
		request.setAttribute("empList", empList);
		RequestDispatcher rd = request.getRequestDispatcher(jspPath);
		rd.forward(request, response);
	}
	@Override
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		doPost(request,response);
	}

	/**
	 * Connectionオブジェクトをクローズするメソッド。
	 *
	 * @param con クローズ対象のConnectionオブジェクト。
	 */
	private void close(Connection con) {
		if(con != null) {
			try {
				con.close();
			}
			catch(SQLException ex) {
				System.out.println("DB接続切断中にSQLexeptionが発生しました："+ex.getMessage());
			}
		}
	}


	/**
	 * PreparedStatementオブジェクトをクローズするメソッド。
	 *
	 * @param ps クローズ対象のPreparedStatementオブジェクト
	 */
	private void close(PreparedStatement ps) {
		if(ps != null) {
			try {
				ps.close();
			}
			catch(SQLException ex) {
				System.out.println("Statementオブジェクト切断中にSQLexeptionが発生しました："+ex.getMessage());
			}
		}
	}

	/**
	 * ResultSetオブジェクトをクローズするメソッド。
	 *
	 * @param rs クローズ対象のResultSetオブジェクト。
	 */
	private void close(ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			}
			catch(SQLException ex) {
				System.out.println("ResultSetオブジェクト切断中にSQLexeptionが発生しました："+ex.getMessage());
			}
		}
	}
}
