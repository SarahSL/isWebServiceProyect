package UniversityWS;

import com.sun.xml.fastinfoset.util.StringArray;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import javax.jws.Oneway;

@WebService(serviceName = "UniversityWS")
@Stateless()
public class UniversityWS {

    
    /** 
     * @param ComunidadAutonoma
     * @return Devuelve las universidades
     */
    @WebMethod(operationName = "InsertarCA")
    public String[] InsertarCA(@WebParam(name = "ComunidadAutonoma") String ComunidadAutonoma) {
        switch(ComunidadAutonoma){
            case "Andalucia":
                String res[]={"Universidad de Almeria",
                "Universidad de Cadiz",
                "Universidad de Cordoba",
                "Universidad de Granada",
                "Universidad de Huelva",
                "Universidad Internacional de Andalucia",
                "Universidad de Jaen",
                "Universidad de Malaga",
                "Universidad Pablo de Olavide",
                "Universidad de Sevilla"};
                return res;
            case "Aragon":
                String result[]={"Universidad de Zaragoza",
                            "Universidad San Jorge"};
                return result;
            
        }
        return null;
    }
    /** 
     * @param CA
     * @return El numero de universidades
     */
    @WebMethod(operationName = "NumberOfUniversity")
    public int NumberOfUniversity(@WebParam(name = "CA") String CA) {
         switch(CA){
            case "Andalucia":
                return 10;
            case "Aragon":
                return 2;
            
        }
        return -1;
    }
    /**
     * 
     * @return La cantidad de universidades
     */
    @WebMethod(operationName = "AllNumberOfUniversity")
    public int AllNumberOfUniversity() {
        int res=0;
        for (String i : AllComunidadA()) {
            res+=NumberOfUniversity(i);
        }
        return res;
    }

    @WebMethod(operationName = "AllComunidadA")
    public String[] AllComunidadA() {
        String[] res={"Andalucia","Aragon"};
        return res;
    }

    @WebMethod(operationName = "NumberOfStudents")
    public int NumberOfStudents(@WebParam(name = "uni") String uni) {
        String[] res=AllUniversity();
        int alumnos[]={5000,4900,1225,6000,3580,4589,6658,6985,1452,3652,7458,3698};
        for (int i = 0; i < res.length; i++) {
            if(res[i].equals(uni)){
                return alumnos[i];
            }
        }
        return -1;
    }

    
    @WebMethod(operationName = "NumberOfAllStudents")
    public int NumberOfAllStudents() {
        
        int res=0;
        int alumnos[]={5000,4900,1225,6000,3580,4589,6658,6985,1452,3652,7458,3698};
        for (int i=0;i<alumnos.length;i++) {
            res+=alumnos[i];
        }
        return res;
    }

    @WebMethod(operationName = "AllUniversity")
    public String[] AllUniversity() {
        String res[]=AllComunidadA();
        String aux[];
        String resultado[]=new String [AllNumberOfUniversity()];
        int a=0;
        for(int i=0;i<res.length;i++){
            aux=InsertarCA(res[i]);
            for(int j=0;j<aux.length;j++){
               resultado[a]=aux[j];
               a++;
            }
        }
        return resultado;
    }
}
