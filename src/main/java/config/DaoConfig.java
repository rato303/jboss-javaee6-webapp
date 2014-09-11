package config;

import static org.seasar.doma.AnnotationTarget.*;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.seasar.doma.AnnotateWith;
import org.seasar.doma.Annotation;

@AnnotateWith(annotations = {
		@Annotation(type = Singleton.class, target = CLASS)
		, @Annotation(type = Inject.class, target = CONSTRUCTOR)
})
public @interface DaoConfig {

}
