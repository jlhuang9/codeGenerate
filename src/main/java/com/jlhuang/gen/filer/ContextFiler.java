package com.jlhuang.gen.filer;

import org.apache.velocity.VelocityContext;

public class ContextFiler {

    public static void proess(VelocityContext context, String tableName) {
        String modelName = getModelName(tableName);
        context.put("base_mapper_package", "com.motorsc.match.base.dto");
        context.put("base_entry_package", "com.motorsc.match.base.dto");
        context.put("mapper_package", "com.motorsc.match.dao."+modelName+".mapper");
        context.put("entry_package", "com.motorsc.match.dto."+modelName+"");
        context.put("dao_package", "com.motorsc.match.dao."+modelName+"");
        context.put("dao_impl_package", "com.motorsc.match.dao."+modelName+".impl");
        context.put("service_package", "com.motorsc.match.service."+modelName+".service");
        context.put("service_impl_package", "com.motorsc.match.services."+modelName+".service.impl");
        context.put("controller_package", "com.motorsc.match.controller."+modelName+"");
    }

    public static final String[] models = {
            "messages",
            "need",
            "appraise",
            "quotation",
            "user",
            "code",
            "log",
    };
    private static String getModelName(String tableNmae) {
        String modelName = "";
        for (int i = 0; i < models.length; i++) {
            String tempModelName = models[i];
            if (tableNmae.contains(tempModelName)) {
                modelName = tempModelName;
                break;
            }
        }
        return modelName;
    }
}
