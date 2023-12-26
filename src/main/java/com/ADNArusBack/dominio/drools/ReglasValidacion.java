package com.ADNArusBack.dominio.drools;

import com.ADNArusBack.dominio.registro.AfiliacionDroolsExcepcion;
import com.ADNArusBack.dominio.registro.modelo.entidad.Registro;
import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;

public class ReglasValidacion {

    public static void validarCriterios(Registro registro) {

        KnowledgeBuilder builder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        builder.add(ResourceFactory
                        .newClassPathResource("rules/rules.drl"),
                ResourceType.DRL);
        if (builder.hasErrors()) {
            throw new RuntimeException(builder.getErrors().toString());
        }
        KnowledgeBase knowledgeBase = KnowledgeBaseFactory.newKnowledgeBase();
        knowledgeBase.addKnowledgePackages(builder.getKnowledgePackages());
        StatefulKnowledgeSession session = knowledgeBase.newStatefulKnowledgeSession();
        session.insert(registro);
        session.fireAllRules();
        session.dispose();
    }
}
