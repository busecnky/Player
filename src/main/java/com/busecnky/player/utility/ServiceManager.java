package com.busecnky.player.utility;

import com.busecnky.player.repository.entity.BaseEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


    @RequiredArgsConstructor
    public class ServiceManager<T extends BaseEntity, ID> implements IService<T, ID> {

        private final JpaRepository<T, ID> jpaRepository;


        @Override
        public T save(T t) {
            t.setUpdateDate(System.currentTimeMillis());
            return jpaRepository.save(t);
        }

        @Override
        public Iterable<T> saveAll(Iterable<T> t) {
            t.forEach(x -> {
                x.setUpdateDate(System.currentTimeMillis());
            });
            return jpaRepository.saveAll(t);
        }

        @Override
        public T update(T t) {
            t.setUpdateDate(System.currentTimeMillis());

            return jpaRepository.save(t);
        }

        @Override
        public void delete(T t) {
            jpaRepository.delete(t);
        }

        @Override
        public void deleteById(ID id) {
            jpaRepository.deleteById(id);
        }

        @Override
        public List<T> findAll() {
            return jpaRepository.findAll();
        }

        @Override
        public Optional<T> findById(ID id) {
            return jpaRepository.findById(id);
        }



    }
