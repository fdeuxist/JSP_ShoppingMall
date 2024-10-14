package com.the.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.the.dto.ProductDTO;
import com.the.service.ProductService;


/**
 * Servlet implementation class ProductController
 */
@WebServlet("*.pdt")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public static ProductService productService = new ProductService();
    	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductController() {
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

		
		String viewPage = "products.jsp";
		
		
		if (command.equals("/product/add.pdt")) {
			viewPage = "add.jsp";
			
		} else if (command.equals("/product/addDB.pdt")) {
			String pdt_name = request.getParameter("pdt_name");
			Integer pdt_cost = Integer.parseInt(request.getParameter("pdt_cost"));
			String pdt_imgpath = request.getParameter("pdt_imgpath");
			
			if(isAdmin(request)) {	//관리자만 상품등록되게
				productService.insert(pdt_name, pdt_cost, pdt_imgpath);
			}
			viewPage = "add.pdt";
			
		} else if (command.equals("/product/products.pdt")) {
			ArrayList<ProductDTO> productDtos = new ArrayList<ProductDTO>();
			productDtos = productService.selectAll();
			request.setAttribute("productDtos", productDtos);
			viewPage = "products.jsp";
		} else if (command.equals("/product/productDetail.pdt")) {
			Integer pdt_no = Integer.parseInt(request.getParameter("pdt_no"));
			ProductDTO productDTO = new ProductDTO();
			productDTO = productService.selectOne(pdt_no);
			request.setAttribute("productDTO", productDTO);
			viewPage = "productDetail.jsp?pdt_no="+pdt_no;
		} else if (command.equals("/product/addToCart.pdt")) {		///// 카트 추가
			HttpSession session = request.getSession();
			//String account_id = (String) session.getAttribute("account_id");

			Integer pdt_no = Integer.parseInt(request.getParameter("pdt_no"));
			String pdt_name = request.getParameter("pdt_name");
			Integer pdt_cost = Integer.parseInt(request.getParameter("pdt_cost"));
			String pdt_imgpath = request.getParameter("pdt_imgpath");
			
			ProductDTO pDto = new ProductDTO(pdt_no,pdt_name,pdt_cost,pdt_imgpath);
			
			ArrayList<ProductDTO> list = (ArrayList)session.getAttribute("productlist");
			if(list == null) {
				list = new ArrayList<ProductDTO>();
				session.setAttribute("productlist",list);
			}
			list.add(pDto);
	
			viewPage = "productDetail.pdt?pdt_no="+pdt_no+"&isPutInCart=true";
		} else if (command.equals("/product/cart.pdt")) {
			/*
			ArrayList list = (ArrayList)session.getAttribute("productlist");
			if(list == null) {
				out.println("선택한 상품이 없습니다.!!!");
			}
			else {
				for(Object productname:list) {
					out.println(productname+"<BR>");
				}
			}
			*/
			
			viewPage = "cart.jsp";
		} else if (command.equals("/product/productCartDelete.pdt")) {
			HttpSession session = request.getSession();
			ArrayList<ProductDTO> list = (ArrayList)session.getAttribute("productlist");
			int index = Integer.parseInt(request.getParameter("productlistIndex"));
			list.remove(index);
			viewPage = "cart.jsp";
		}

		System.out.println("viewPage ->" + viewPage);
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
	}
	
	public static boolean isAdmin(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("account_id");
		if(id.equals("admin")) {
			return true;
		}else {
			return false;
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
