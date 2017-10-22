package com.resumely.rest;

import com.resumely.LineList;
import com.resumely.Parser;
import com.resumely.modules.AbstractFile;
import com.resumely.object.Resume;
import com.resumely.util.ResumeUtil;

import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/resume")
@Produces(MediaType.APPLICATION_JSON)
public class ResumeService {
    
    @GET
    public String getResume(){
        
        
        //create the file with the command argument
        AbstractFile resume = new Resume("com\\resumely\\resume.doc");
        //read the content row by row from the document
        ResumeUtil.getInstance().readContent(resume);  
        //extract word by word
        LineList list = new LineList();
        Parser.lineTokenize(resume.getContent(),list);
        //identify first 10 lines and work on those words
//        for(int i=0;i<list.getLines().size();i++){
//            //System.out.println(list.getLines().get(i).getWordCount());
//            Line line = list.getLines().get(i);
//        }
        
        StringBuilder result = new StringBuilder();
        result.append("{ \"result\" : [");
        for(Map.Entry<String,Integer> entry : list.getWordMap().entrySet()){
                    //System.out.println(entry.getKey() + ":" + entry.getValue());
                    result.append("{ \""+ entry.getKey() +"\" : ");
                    result.append("{ \""+ entry.getValue() +"\" }");
                    result.append(",");
        }
        int length = result.toString().length();
        result.deleteCharAt(length-1);
        result.append("]");
        result.append("}");
        return result.toString();
    }
}
