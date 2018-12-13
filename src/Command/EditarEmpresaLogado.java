package Command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Empresa;
import Service.EmpresaService;

public class EditarEmpresaLogado implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Empresa usua = (Empresa) session.getAttribute("empresa_logada");

		Empresa emp = new Empresa();

		EmpresaService es = new EmpresaService();

		RequestDispatcher view = null;

		emp = es.carregarEmpDocumento(emp.getEmpresaCNPJ());
		request.setAttribute("empresa", usua);
		view = request.getRequestDispatcher("AlterarEmpresaLogado.jsp");

		view.forward(request, response);

	}

	public int busca(Empresa emp, ArrayList<Empresa> lista) {
		Empresa to;
		for (int i = 0; i < lista.size(); i++) {
			to = lista.get(i);
			if (to.getId() == emp.getId()) {
				return i;
			}
		}
		return -1;
	}

}
