package local.hal.night.javawebdb;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * JavaWebDB Lesson Chap01 Src03
 *
 * 部門情報表示。
 *
 * @author yuyas
 */
@WebServlet(name="showDeptInfoServlet",urlPatterns= {"/showDeptInfo"})
public class ShowDeptInfoServlet extends HttpServlet{
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
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		String jspPath = "/selectDeptno.jsp";

		request.setCharacterEncoding("UTF-8");
		String deptnoStr = request.getParameter("deptno");
		int deptnoInt = Integer.parseInt(deptnoStr);
		if(deptnoInt == -1) {
			request.setAttribute("errorMsg", "部門番号を選択してください。");
		}
		else {
			Connection con = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			String sql = "SELECT * FROM dept WHERE deptno = ?";
			try {
				con = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
				stmt = con.prepareStatement(sql);
				stmt.setInt(1, deptnoInt);
				rs = stmt.executeQuery();
				if(rs.next()) {
					Integer deptno = rs.getInt("deptno");
					String dname = rs.getString("dname");
					String loc = rs.getString("loc");

					Dept dept = new Dept();
					dept.setDeptno(deptno);
					dept.setDname(dname);
					dept.setLoc(loc);
					request.setAttribute("dept", dept);
					jspPath = "/deptInfo.jsp";
				}
				else {
					request.setAttribute("errorMsg", "部門情報の取得に失敗しました。もう一度はじめから操作をお願いします。");
				}
			}
			catch(SQLException ex) {
				ex.printStackTrace();
				request.setAttribute("errotMsg", "もう一度はじめから操作をお願いします。");
			}
			catch(Exception ex){
				ex.printStackTrace();
				request.setAttribute("errotMsg", "もう一度はじめから操作をお願いします。");
			}
			finally {
				close(rs);
				close(stmt);
				close(con);
			}
		}

		RequestDispatcher rd = request.getRequestDispatcher(jspPath);
		rd.forward(request, response);
	}

	@Override
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
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
