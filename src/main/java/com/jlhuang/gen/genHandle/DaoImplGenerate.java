package com.jlhuang.gen.genHandle;

import com.jlhuang.gen.util.VelocityUtil;
import com.jlhuang.gen.filer.Filer;
import com.jlhuang.gen.message.Message;
import com.jlhuang.gen.moudel.Column;
import com.jlhuang.gen.moudel.Table;
import org.apache.velocity.VelocityContext;

import java.util.List;

public class DaoImplGenerate implements Generate {

    @Override
    public void proess(String modelPath, Filer filer, VelocityContext context, Table table) {
        modelPath = Message.DAO_IMPL_VM_PATH;
        System.out.println("start made DaoImpl");
        String dao_impl_package = (String) context.get("dao_impl_package");
        String base_path = (String)context.get("base_path");

        String model = table.getCamelTableName();
        String outPath = base_path + "/src/main/java/" + dao_impl_package.replace(".", "/") + "/" + model + "DaoImpl.java";
        List<Column> columns = table.getColumns();
        //过滤
        List<Column> columns1 = filer.columnFiler(columns);
        context.put("columns",columns1);

        try {
            VelocityUtil.generate(modelPath,outPath,context);
        } catch (Exception e) {
             e.printStackTrace();
        }
        System.out.println("end");
    }


}
