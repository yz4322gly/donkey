package xin.tomdonkey.annotation.processor;

import com.google.auto.service.AutoService;
import xin.tomdonkey.annotation.annotation.Context;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import java.util.LinkedHashSet;
import java.util.Set;

@AutoService(Processor.class)
public class MyProcessor extends AbstractProcessor
{
    private Messager messager;

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv)
    {
        messager.printMessage(Diagnostic.Kind.ERROR,"cao!");
        for (Element annotatedElement:roundEnv.getElementsAnnotatedWith(Context.class))
        {
            if (annotatedElement.getKind() == ElementKind.METHOD)
            {
                ExecutableElement element = (ExecutableElement) annotatedElement;
                messager.printMessage(Diagnostic.Kind.ERROR,element.getSimpleName());
                messager.printMessage(Diagnostic.Kind.ERROR,element.getSimpleName(),element);
            }
        }
        return false;
    }

    @Override
    public Set<String> getSupportedOptions()
    {
        return super.getSupportedOptions();
    }

    @Override
    public Set<String> getSupportedAnnotationTypes()
    {
        Set<String> annotations = new LinkedHashSet<>();
        annotations.add(Context.class.getCanonicalName());
        return annotations;
    }

    @Override
    public SourceVersion getSupportedSourceVersion()
    {
        return SourceVersion.latestSupported();
    }

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv)
    {
        messager = processingEnv.getMessager();
    }
}
