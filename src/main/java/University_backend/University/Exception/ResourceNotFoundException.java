package University_backend.University.Exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String fullstack,Object...args){
        super(String.format(fullstack,args));
    }
}