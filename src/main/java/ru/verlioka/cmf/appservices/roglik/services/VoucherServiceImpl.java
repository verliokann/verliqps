package ru.verlioka.cmf.appservices.roglik.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.verlioka.cmf.appservices.roglik.controllers.json.BeachTypes;
import ru.verlioka.cmf.appservices.roglik.controllers.json.CertainBeachVoucher;
import ru.verlioka.cmf.appservices.roglik.controllers.json.CertainBeachVouchers;
import ru.verlioka.cmf.appservices.roglik.controllers.json.LowCostVouchers;
import ru.verlioka.cmf.appservices.roglik.dao.interfaces.VoucherDao;
import ru.verlioka.cmf.appservices.roglik.models.VoucherEntity;
import ru.verlioka.cmf.core.services.generic.db.GenericServiceImpl;

import javax.persistence.Query;
import java.util.*;
import java.util.stream.Collectors;

@Service("voucherService")
public class VoucherServiceImpl extends GenericServiceImpl<VoucherEntity, Long> implements VoucherService {
    public VoucherServiceImpl() {
    }

    @Autowired
    public VoucherServiceImpl(VoucherDao voucherDao) {
        super(voucherDao);
    }

    public VoucherDao getVoucherDao() {
        return (VoucherDao) getGenericDao();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<LowCostVouchers> getVouchersBelowCertainPrice(Integer price) {
        Query q = getVoucherDao().getEntityManager().createQuery("from VoucherEntity");
        List<VoucherEntity> v = (List<VoucherEntity>) q.getResultList();

        return v.stream()
                .filter(voucher -> voucher.getCost() <= price)
                .map(voucher -> {
                    LowCostVouchers result = new LowCostVouchers();
                    result.setBeachName(voucher.getBeachName());
                    result.setCost(voucher.getCost());
                    result.setCountryName(voucher.getHotel().getCountry().getName());
                    return result;
                })
                .sorted(Comparator.comparingDouble(LowCostVouchers::getCost))
                .collect(Collectors.toList());
    }

    @Override
    @SuppressWarnings("unchecked")
    public CertainBeachVouchers getVouchersByBeachType(String beachType) {
        List<CertainBeachVoucher> certainVouchers = getVoucherDao().getAll().stream()
                .map(obj -> (VoucherEntity) obj)
                .filter(voucher -> voucher.getBeachType().equalsIgnoreCase(beachType))
                .map(voucher -> {
                    CertainBeachVoucher result = new CertainBeachVoucher();
                    result.setCountryName(voucher.getHotel().getCountry().getName());
                    result.setHotelName(voucher.getHotel().getName());
                    result.setBeachName(voucher.getBeachName());
                    result.setDepartureDate(voucher.getStart());
                    result.setArrivalDate(voucher.getEnd());
                    result.setDays(voucher.getDays());
                    result.setCost(voucher.getCost());
                    result.setDiscountedCost(voucher.getCost() * (1 - 0.3));
                    return result;
                })
                .sorted(Comparator.comparing(CertainBeachVoucher::getHotelName))
                .collect(Collectors.toList());

        CertainBeachVouchers totalResult = new CertainBeachVouchers();
        totalResult.setVouchers(certainVouchers);
        totalResult.setTotalCost(certainVouchers.stream().mapToDouble(CertainBeachVoucher::getCost).sum());
        totalResult.setTotalDiscountedCost(certainVouchers.stream().mapToDouble(CertainBeachVoucher::getDiscountedCost).sum());
        return totalResult;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<BeachTypes> getBeachReport() {
        Map<String, List<VoucherEntity>> grouped = new HashMap<>();

        for (VoucherEntity e : getVoucherDao().getAll().stream().map(obj -> (VoucherEntity) obj).collect(Collectors.toList())) {
            grouped.computeIfAbsent(e.getBeachType(), k -> new ArrayList<>());
            grouped.get(e.getBeachType()).add(e);
        }

        List<BeachTypes> result = new ArrayList<>();

        for (String beachType : grouped.keySet()) {
            BeachTypes t = new BeachTypes();
            t.setBeachType(beachType);
            t.setTotalCost(grouped.get(beachType).stream().mapToDouble(VoucherEntity::getCost).sum());
            t.setVouchersAmount(grouped.get(beachType).size());
            result.add(t);
        }

        result.sort(Comparator.comparing(BeachTypes::getBeachType));
        return result;
    }
}
