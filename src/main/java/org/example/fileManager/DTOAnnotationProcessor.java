//package org.example.fileManager;
//
//import com.google.auto.service.AutoService;
//
//import javax.annotation.processing.*;
//import javax.lang.model.SourceVersion;
//import javax.lang.model.element.Element;
//import javax.lang.model.element.ElementKind;
//import javax.lang.model.element.TypeElement;
//import javax.tools.JavaFileObject;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.List;
//import java.util.Set;
//
//import static java.lang.annotation.ElementType.FIELD;
//import static java.util.stream.Collectors.joining;
//
//@SupportedAnnotationTypes("org.example.IncludeInDTO")
//@SupportedSourceVersion(SourceVersion.RELEASE_17)
//@AutoService(Processor.class)
//public class DTOAnnotationProcessor extends AbstractProcessor {
//
////    @Override
////    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
////        for (TypeElement annotation : annotations) {
////            for (Element element : roundEnv.getElementsAnnotatedWith(annotation)) {
////                String className = null;
////                String fieldName = null;
////                String fieldType = null;
////
////                if (element.getKind() == ElementKind.CLASS) {
////                    className = ((TypeElement) element).getQualifiedName().toString();
////                } else if (element.getKind() == ElementKind.FIELD) {
////                    fieldName = element.getSimpleName().toString();
////                    fieldType = element.asType().toString();
////                    className = ((TypeElement) element.getEnclosingElement()).getQualifiedName().toString();
////                }
////
////                generateDTOClass(className, fieldName, fieldType);
////            }
////        }
////        System.out.println("xd1");
////        return true;
////    }
////
////    private void generateDTOClass(String className, String fieldName, String fieldType) {
////        String dtoClassName = className + "DTO";
////        String packageName = processingEnv.getElementUtils().getPackageOf(
////                processingEnv.getElementUtils().getTypeElement(className)).getQualifiedName().toString();
////
////        String dtoClassSourceCode = generateDTOClassSourceCode(dtoClassName, packageName, fieldName, fieldType);
////
////        try {
////            JavaFileObject jfo = processingEnv.getFiler().createSourceFile(packageName + "." + dtoClassName);
////            try (PrintWriter out = new PrintWriter(jfo.openWriter())) {
////                out.println(dtoClassSourceCode);
////            }
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
////        System.out.println("xd2");
////    }
////
////    private String generateDTOClassSourceCode(String dtoClassName, String packageName, String fieldName, String fieldType) {
////        System.out.println("xd3");
////        return String.format("package %s;\n\npublic class %s {\n\n" +
////                        "    private %s %s;\n\n" +
////                        "    public %s() {\n" +
////                        "    }\n\n" +
////                        "    public %s(%s %s) {\n" +
////                        "        this.%s = %s;\n" +
////                        "    }\n\n" +
////                        "    public %s get%s() {\n" +
////                        "        return %s;\n" +
////                        "    }\n\n" +
////                        "    public void set%s(%s %s) {\n" +
////                        "        this.%s = %s;\n" +
////                        "    }\n" +
////                        "}\n", packageName, dtoClassName, fieldType, fieldName, dtoClassName, dtoClassName,
////                fieldType, fieldName, fieldName, fieldName, fieldType, fieldName, fieldName,
////                fieldName, fieldName, fieldName, fieldName);
////    }
//@Override
//public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
//    annotations.forEach(annotation ->
//            roundEnv.getElementsAnnotatedWith(annotation)
//                    .forEach(this::generateBuilderFile)
//    );
//    return true;
//}
//
//    private void generateBuilderFile(Element element) {
//        String className = element.getSimpleName().toString();
//        String packageName = element.getEnclosingElement().toString();
//        String builderName = className + "com.youtube.geekific.Builder";
//        String builderFullName = packageName + "." + builderName;
//        List<? extends Element> fields = element.getEnclosedElements()
//                .stream().filter(e -> FIELD.equals(e.getKind())).toList();
//
//        try (PrintWriter writer = new PrintWriter(
//                processingEnv.getFiler().createSourceFile(builderFullName).openWriter())) {
//            writer.println("""
//                    package %s;
//
//                    public class %s {
//                    """
//                    .formatted(packageName, builderName)
//            );
//
//            fields.forEach(field ->
//                    writer.print("""
//                                private %s %s;
//                            """.formatted(field.asType().toString(), field.getSimpleName())
//                    )
//            );
//
//            writer.println();
//            fields.forEach(field ->
//                    writer.println("""
//                                public %s %s(%s value) {
//                                    %s = value;
//                                    return this;
//                                }
//                            """.formatted(builderName, field.getSimpleName(),
//                            field.asType().toString(), field.getSimpleName())
//                    )
//            );
//
//            writer.println("""
//                        public %s build() {
//                            return new %s(%s);
//                        }
//                    """.formatted(className, className,
//                    fields.stream().map(Element::getSimpleName).collect(joining(", ")))
//            );
//            writer.println("}");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//}
//
