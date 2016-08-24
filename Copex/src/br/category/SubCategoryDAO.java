/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.category;


import br.util.GenericDAO;
import br.util.HibernateUtil;
import java.util.List;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author João
 */
public class SubCategoryDAO extends GenericDAO<SubCategory> {
    
    public SubCategoryDAO() {
        super(SubCategory.class);
    }
    
    public List<SubCategory> listarPorCategoria(Category categoria){
        this.setSessao(HibernateUtil.getSessionFactory().openSession());
        List<SubCategory> lista;
        lista = getSessao().createCriteria(SubCategory.class).add(Restrictions.eq("categoria", categoria)).list();
        return lista;
    }
}
