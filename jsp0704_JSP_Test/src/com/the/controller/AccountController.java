package com.the.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.the.dto.AccountDTO;
import com.the.service.AccountService;

/**
 * Servlet implementation class AccountController
 */
@WebServlet("*.ac")
public class AccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public static AccountService accountService = new AccountService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// URI:/jsp10/hello.do
		// conPath:/jsp10
		// command:/hello.do
		String uri = request.getRequestURI();
		 System.out.println("URI:" + uri); //원하는 주소에 대한 처리 방법
		String conPath = request.getContextPath();
		 System.out.println("conPath:" + conPath);
		String command = uri.substring(conPath.length());
		 System.out.println("command:" + command);

		//String viewPage = "login.jsp";
		String viewPage = "";
		
		
		if (command.equals("/account/loginDB.ac")) {
			String account_id = request.getParameter("account_id");
			String account_pw = request.getParameter("account_pw");

			AccountService accountService = new AccountService();
			AccountDTO loginAccountDTO = accountService.login(account_id, account_pw);
			
			if(loginAccountDTO!=null) {
				if (loginAccountDTO.getAccount_id().equals(account_id) &&
						loginAccountDTO.getAccount_pw().equals(account_pw)) {
					HttpSession session = request.getSession();
					session.setAttribute("account_id", account_id);
					session.setMaxInactiveInterval(600);
					viewPage = "success.jsp";
				}
			}else {
				viewPage = "login.jsp?isSuccess=false";
			}
			
		} else if (command.equals("/account/logout.ac")) {
//			String user_id = (String) request.getAttribute("user_id");
//			Cookie cookie = new Cookie("user_id", user_id);
//			cookie.setMaxAge(0);
//			response.addCookie(cookie);
			HttpSession session = request.getSession();
			//String account_id = (String) session.getAttribute("account_id");
			//session.removeAttribute("account_id");	
			session.invalidate();
			//System.out.println("logout account_id : [" + session.getAttribute("account_id") + "]");
			viewPage = "login.jsp?isLogout=true";
			
		} else if (command.equals("/account/join.ac")) {
			viewPage = "join.jsp";
			
		} else if (command.equals("/account/joinDB.ac")) {
			String account_id = request.getParameter("account_id");
			String account_pw = request.getParameter("account_pw");
			String account_name = request.getParameter("account_name");
			String account_phone = request.getParameter("account_phone");
			String account_address = request.getParameter("account_address");
			accountService.join(account_id, account_pw, account_name, account_phone, account_address);
			HttpSession session = request.getSession();
			session.setAttribute("account_id", account_id);
			session.setMaxInactiveInterval(600);
			viewPage = "success.jsp";
			
		} else if (command.equals("/account/accountUpdate.ac")) {	//success.jsp 에서 누를수있음, 세션에 account_id 가지고있음
			HttpSession session = request.getSession();
			String account_id = (String) session.getAttribute("account_id");
			AccountDTO updateUserDTO = accountService.selectOne(account_id);
			session.setAttribute("updateUserDTO", updateUserDTO);
			viewPage = "accountupdate.jsp";
			
		} else if (command.equals("/account/accountUpdateDB.ac")) {
			
			HttpSession session = request.getSession();
			String account_id = (String) session.getAttribute("account_id");	//id는 로그인 세션에서 가져옴
			if(account_id!=null) { //로그인 -> 수정페이지에서 대기 -> 세션유효시간지나고 수정버튼 누르면 id가 null
				AccountDTO updateUserDTO = accountService.selectOne(account_id);	//로그인 된 id로 account_no 가져옴
				Integer account_no = (Integer) updateUserDTO.getAccount_no();
				
				String account_pw = request.getParameter("account_pw");	//수정할 값들은 request에서 가져옴
				String account_name = request.getParameter("account_name");
				String account_phone = request.getParameter("account_phone");
				String account_address = request.getParameter("account_address");
				
				accountService.update(account_no, account_id, account_pw, account_name, account_phone, account_address);
				
				viewPage = "accountUpdate.ac";
			}else {
				viewPage = "login.ac";
			}
			
		} else if (command.equals("/account/success.ac")) {
			viewPage = "success.jsp";
		} else if (command.equals("/account/login.ac")) {
			viewPage = "login.jsp";
		} else if (command.equals("/account/accountDelete.ac")) {
			HttpSession session = request.getSession();
			String account_id = (String) session.getAttribute("account_id");
			accountService.delete(account_id);
			session.invalidate();
			viewPage = "logout.ac";
		}
		System.out.println("viewPage ->" + viewPage);
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
