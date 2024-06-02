package dz.airalgerie.grh.model.entities.gp;

/**
 * @author Root
 */
import org.eclipse.persistence.config.DescriptorCustomizer;
import org.eclipse.persistence.descriptors.ClassDescriptor;
import org.eclipse.persistence.expressions.*;
import org.eclipse.persistence.mappings.OneToManyMapping;

public class RelationCustomizer implements DescriptorCustomizer {

  public void customize(ClassDescriptor descriptor) {
    OneToManyMapping listEnf = (OneToManyMapping) descriptor.getMappingForAttributeName("listEnf");
    OneToManyMapping listPrT = (OneToManyMapping) descriptor.getMappingForAttributeName("listPrT");
    OneToManyMapping listPerAc = (OneToManyMapping) descriptor.getMappingForAttributeName("listPerac");
    
    ExpressionBuilder ebEn = new ExpressionBuilder(listEnf.getReferenceClass());
    Expression fkExpEn = ebEn.getField("MATRICULE").equal(ebEn.getParameter("MATRICULE"));
    Expression activeExpEn = ebEn.get("droitGp").equal(true);
    listEnf.setSelectionCriteria(fkExpEn.and(activeExpEn));
    
    ExpressionBuilder ebPa = new ExpressionBuilder(listPrT.getReferenceClass());
    Expression fkExpPa = ebPa.getField("MATRICULE").equal(ebPa.getParameter("MATRICULE"));
    Expression activeExpPa = ebPa.get("droitGp").equal(true);
    listPrT.setSelectionCriteria(fkExpPa.and(activeExpPa));
    
    ExpressionBuilder ebPac = new ExpressionBuilder(listPerAc.getReferenceClass());
    Expression fkExpPac = ebPac.getField("MATRICULE").equal(ebPac.getParameter("MATRICULE"));
    Expression activeExpPac = ebPac.get("droitGp").equal(true);
    listPerAc.setSelectionCriteria(fkExpPac.and(activeExpPac));
  }
}
