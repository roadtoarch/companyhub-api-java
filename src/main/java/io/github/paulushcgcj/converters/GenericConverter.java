package io.github.paulushcgcj.converters;

import java.lang.reflect.ParameterizedType;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import ma.glasnost.orika.metadata.ClassMapBuilder;

@Slf4j
public abstract class GenericConverter<A, B> {
  protected MapperFactory mapperFactory;

  public A toA(B value) {
    return mapperFactory.getMapperFacade().map(value, getFirstClass());
  }

  public B toB(A value) {
    return mapperFactory.getMapperFacade().map(value, getSecondClass());
  }

  public GenericConverter() {
    mapRegistry();
  }

  abstract Map<String, String> createMap();

  private void mapRegistry() {
    mapperFactory = new DefaultMapperFactory.Builder().build();
    ClassMapBuilder mapBuilder = mapperFactory.classMap(getFirstClass(), getSecondClass());
    createMap().forEach(mapBuilder::field);
    mapBuilder.byDefault().register();
  }

  private Class<A> getFirstClass() {
    return (Class<A>) getReceivedClass(0);
  }

  private Class<B> getSecondClass() {
    return (Class<B>) getReceivedClass(1);
  }

  private Class getReceivedClass(int argumentPosition) {
    Class clientClass = getClass();
    ParameterizedType parameterizedType = ((ParameterizedType) clientClass.getGenericSuperclass());
    return ((Class) parameterizedType.getActualTypeArguments()[argumentPosition]);
  }
}
