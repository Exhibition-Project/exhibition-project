package kosta.mvc.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import kosta.mvc.model.dto.ExhibitionDTO;
import kosta.mvc.model.service.ExhibitionService;
import kosta.mvc.session.Session;
import kosta.mvc.session.SessionSet;
import kosta.mvc.view.EndView;
import kosta.mvc.view.FailView;

public class CartController {
	private static ExhibitionService exhibitionService = new ExhibitionService();

	public static void putCart(String id, int exhibitionNo, int quantity) {

		try {
			//전시회번호에 해당 전시회찾기
			ExhibitionDTO exhibition = exhibitionService.selectByExhibitionxNo(exhibitionNo);
			//1	카게에 거장 후지시로 세이지 빛과 그림자의 판타지 전	21/06/10	21/10/12	회화	1000	한가람미술관
			
			//id에 해당하는 세션찾기
			SessionSet ss = SessionSet.getInstance();
			Session session = ss.get(id);	

			//세션에서 장바구니 찾기
			Map<ExhibitionDTO, Integer> cart =	(Map<ExhibitionDTO,Integer>)session.getAttribute("cart"); //전시회 , 수량 저장 

			//장바구니가 없으면 장바구니 생성
			if(cart == null) { 
				cart = new HashMap<>(); 
				session.setAttribute("cart", cart);
			}

			//장바구니에서 상품찾기
			Integer oldQuantity = cart.get(exhibition);
			if(oldQuantity != null) { //장바구니에 이미 상품이 있다면
				quantity += oldQuantity; //수량을 누적
			}

			cart.put(exhibition, quantity); //장바구니에 상품 넣기
			EndView.printMessage("장바구니에 담았습니다");
		}catch(Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}

	/**
	 * 장바구니 보기
	 * */
	public static void viewCart(String id) {
		SessionSet ss = SessionSet.getInstance();
		Session session = ss.get(id);

		Map<ExhibitionDTO,Integer> cart = (Map<ExhibitionDTO, Integer>) session.getAttribute("cart");
		if(cart == null ) { // 장바구니가 없는 고객
			FailView.errorMessage("장바구니가 비었습니다");
		}else {
//			EndView.printViewCart(id , cart);
		}
	}
}




