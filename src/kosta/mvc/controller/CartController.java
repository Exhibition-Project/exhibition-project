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
			//����ȸ��ȣ�� �ش� ����ȸã��
			ExhibitionDTO exhibition = exhibitionService.selectByExhibitionxNo(exhibitionNo);
			//1	ī�Կ� ���� �����÷� ������ ���� �׸����� ��Ÿ�� ��	21/06/10	21/10/12	ȸȭ	1000	�Ѱ����̼���
			
			//id�� �ش��ϴ� ����ã��
			SessionSet ss = SessionSet.getInstance();
			Session session = ss.get(id);	

			//���ǿ��� ��ٱ��� ã��
			Map<ExhibitionDTO, Integer> cart =	(Map<ExhibitionDTO,Integer>)session.getAttribute("cart"); //����ȸ , ���� ���� 

			//��ٱ��ϰ� ������ ��ٱ��� ����
			if(cart == null) { 
				cart = new HashMap<>(); 
				session.setAttribute("cart", cart);
			}

			//��ٱ��Ͽ��� ��ǰã��
			Integer oldQuantity = cart.get(exhibition);
			if(oldQuantity != null) { //��ٱ��Ͽ� �̹� ��ǰ�� �ִٸ�
				quantity += oldQuantity; //������ ����
			}

			cart.put(exhibition, quantity); //��ٱ��Ͽ� ��ǰ �ֱ�
			EndView.printMessage("��ٱ��Ͽ� ��ҽ��ϴ�");
		}catch(Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}

	/**
	 * ��ٱ��� ����
	 * */
	public static void viewCart(String id) {
		SessionSet ss = SessionSet.getInstance();
		Session session = ss.get(id);

		Map<ExhibitionDTO,Integer> cart = (Map<ExhibitionDTO, Integer>) session.getAttribute("cart");
		if(cart == null ) { // ��ٱ��ϰ� ���� ��
			FailView.errorMessage("��ٱ��ϰ� ������ϴ�");
		}else {
//			EndView.printViewCart(id , cart);
		}
	}
}




